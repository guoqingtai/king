package knight.b0_mnt.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import knight.b0_mnt.entity.TResource;
import knight.b0_mnt.entity.TRole;
import knight.b0_mnt.entity.TUser;

@Repository
public interface TMntDao {
	TUser queryByName(String userName);
	List<TRole> queryRoleById(int userId);
	List<TRole> queryRole();
	List<TResource> queryResourceByRoleId(int roleId);	
} 
