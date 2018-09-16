package com.imooc.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/13
 * Time: 14:31
 * Description:  自定义webSessionManager  解决频繁访问redis
 */
public class CustomSessionManager extends DefaultWebSessionManager {


    private static final Logger log = LoggerFactory.getLogger(CustomSessionManager.class);

    @Override
    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
        Serializable sessionId = getSessionId(sessionKey);
        ServletRequest request =null;
        if (sessionKey instanceof WebSessionKey){
            request = ((WebSessionKey)sessionKey).getServletRequest();
        }
        if(request !=null && sessionId !=null){
           Session session  = (Session) request.getAttribute(sessionId.toString());
           if(session !=null){
               return session;
            }
        }
        Session session = super.retrieveSession(sessionKey);
        if(request !=null && sessionId !=null ){
            request.setAttribute(sessionId.toString(),session);
        }
        return session;
    }
}
