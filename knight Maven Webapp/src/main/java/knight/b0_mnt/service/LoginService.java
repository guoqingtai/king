package knight.b0_mnt.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import knight.b0_mnt.dao.TUserDao;
import knight.b0_mnt.entity.TUser;

@Service
public class LoginService {
	
	Logger LOG = Logger.getLogger(getClass());
	
	@Autowired TUserDao dao;
	
	public void getUser(String userName) {
		if (dao == null) {
			LOG.error("dao is not created!");
		}
		TUser user = dao.queryByName(userName);
		System.out.println(user.getPassword());
	}
	

}
