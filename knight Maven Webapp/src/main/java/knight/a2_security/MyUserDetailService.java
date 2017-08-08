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

import knight.b0_mnt.service.LoginService;

public class MyUserDetailService implements UserDetailsService {

	@Autowired
	LoginService login;
	
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
    	
    	System.out.println("LOGIN:" + login);
        Collection<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();
        SimpleGrantedAuthority auth2=new SimpleGrantedAuthority("ROLE_ADMIN");
        auths.add(auth2);
        if(username.equals("robin1")){
            //auths=new ArrayList<GrantedAuthority>();
            SimpleGrantedAuthority auth1=new SimpleGrantedAuthority("ROLE_ROBIN");
            auths.add(auth1);
        }
        
//        User(String username, String password, boolean enabled, boolean accountNonExpired,
//                    boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities) {
        User user = new User(username,
                "robin", true, true, true, true, auths);
        return user;
    }
    
}
