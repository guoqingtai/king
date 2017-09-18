package knight.b0_mnt.entity;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import knight.b0_mnt.service.LoginService;

/**
 * 根据用户ID获取Role和Resource。
 * 
 * @author admin
 *
 */
public class MntUtils {
	@Autowired
	private static LoginService svs;
	
	private static HashMap<Integer, String> roleMap = new HashMap<Integer, String>();

	public static void getRoleMap() {
		if (roleMap == null || roleMap.isEmpty()) {
			List<TRole> roles = svs.getRoles();
			for (TRole role : roles) {
				System.out.println(MntUtils.class+" "+role.getRoleName());
				roleMap.put(role.getRoleId(), role.getRoleName());
			}
		}
	}
}
