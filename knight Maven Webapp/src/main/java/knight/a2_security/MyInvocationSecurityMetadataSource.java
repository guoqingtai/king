package knight.a2_security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
//import org.springframework.security.web.util.AntUrlPathMatcher;
//import org.springframework.security.web.util.UrlMatcher;
import org.springframework.util.PathMatcher;

import knight.b0_mnt.entity.TResource;
import knight.b0_mnt.entity.TRole;
import knight.b0_mnt.service.LoginService;

/**
 * 
 * 此类在初始化时，应该取到所有资源及其对应角色的定义
 * 
 * @author Robin
 * 
 */
public class MyInvocationSecurityMetadataSource
        implements FilterInvocationSecurityMetadataSource {
    private PathMatcher urlMatcher = new AntPathMatcher();
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    private static LoginService SRV;
    
    public MyInvocationSecurityMetadataSource(LoginService service) {
        
    	SRV = service;
        loadResourceDefine();
    }
    
    /**
     * 设置新role时，可以实时刷新。
     */
    public static synchronized void loadResourceDefine() {
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        //Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        //ConfigAttribute ca = new SecurityConfig("ROLE_ADMIN");
        //atts.add(ca);
        //resourceMap.put("/index.htm", atts);
        //resourceMap.put("/i.jsp", atts);
        List<TRole> roles = SRV.getRoles();
        for (TRole role : roles) {
        	ConfigAttribute attribute = new SecurityConfig(role.getRoleName());
        	Collection<ConfigAttribute> collcections = new ArrayList<ConfigAttribute>();
        	collcections.add(attribute);
        	List<TResource> rscs = SRV.getResourceByRoleId(role.getRoleId());
        	for (TResource rsc : rscs) {
        		resourceMap.put(rsc.getUri(),collcections);
        	}
        }
        String s = "";
        s = s+1;
    }

    // According to a URL, Find out permission configuration of this URL.
    public synchronized Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        // guess object is a URL.
        String url = ((FilterInvocation)object).getRequestUrl();
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            if (urlMatcher.match(resURL, url)) {
                 return resourceMap.get(resURL);
            }
        }
        return null;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }
    
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

}