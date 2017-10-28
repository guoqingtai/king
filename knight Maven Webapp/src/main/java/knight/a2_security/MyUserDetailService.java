package knight.a2_security;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import knight.a1_common_utils.Md5Util;
import knight.b0_mnt.entity.TRole;
import knight.b0_mnt.entity.TUser;
import knight.b0_mnt.service.LoginService;

public class MyUserDetailService implements UserDetailsService {

	@Autowired
	LoginService login;
	
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
    	
    	System.out.println("LOGIN:" + login);
    	
    	TUser user = login.getUser(username);
    	//用户不存在
    	if (user == null || user.getRoles() == null || user.getRoles().size() == 0) {
    		return null;
    	}
    	else {
    		Collection<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();
    		for (TRole role : user.getRoles()) {
    			SimpleGrantedAuthority auth=new SimpleGrantedAuthority(String.valueOf(role.getRoleId()));
    			auths.add(auth);
    		}
    		User res = new User(username,
                    user.getPassword(), true, true, true, true, auths);
    		
    		return res;
    		
    	}
       // Collection<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();
       // SimpleGrantedAuthority auth2=new SimpleGrantedAuthority("admin");
       // auths.add(auth2);
       // System.out.println(Md5Util.GetMD5Code("robin"));
       // User user = new User(username,
       //         Md5Util.GetMD5Code("robin"), true, true, true, true, auths);
    }
    
}
