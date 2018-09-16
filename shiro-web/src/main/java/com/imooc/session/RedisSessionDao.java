package com.imooc.session;

import com.imooc.utils.JedisUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SerializationUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/13
 * Time: 11:13
 * Description:
 * 会话管理
 */
public class RedisSessionDao extends AbstractSessionDAO {

    @Resource
    private JedisUtil jedisUtil;

    private final String SHIRO_SESSION_PREFIX = "imooc-session";

    private byte[] getKey(String key){
        return (SHIRO_SESSION_PREFIX+key).getBytes();
    }
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        //将sessionId 和session捆绑
        assignSessionId(session,sessionId);
        saveSession(session);
        return sessionId;
    }
    @Override
    protected Session doReadSession(Serializable sessionId) {
        System.out.println("read session");
        if(sessionId ==null){
            return  null;
        }
        byte[] key = getKey(sessionId.toString());
        byte[]  value = jedisUtil.get(key);
        return (Session) SerializationUtils.deserialize(value);
    }

    public void update(Session session) throws UnknownSessionException {
        saveSession(session);
    }

    public void delete(Session session) {
        if(session !=null && session.getId() !=null){
            byte[] key = getKey(session.getId().toString());
            jedisUtil.del(key);
        }
    }

    public Collection<Session> getActiveSessions() {
        Set<byte[]> keys = jedisUtil.keys(SHIRO_SESSION_PREFIX);
        Set<Session> sessions =new HashSet<Session>();
        if(CollectionUtils.isEmpty(keys)){
            return sessions;
        }
        for(byte[] key:keys){
            Session session =(Session)SerializationUtils.deserialize(jedisUtil.get(key));
            sessions.add(session);
        }

        return sessions;
    }

    private void saveSession(Session session){
        if(session !=null && session.getId() !=null){
            byte[] key = getKey(session.getId().toString());
            byte[] value = SerializationUtils.serialize(session);
            jedisUtil.set(key,value);
            jedisUtil.expire( key,600);
        }
    }
}
