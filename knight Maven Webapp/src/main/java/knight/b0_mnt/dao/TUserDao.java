package knight.b0_mnt.dao;

import org.springframework.stereotype.Repository;

import knight.b0_mnt.entity.TUser;

@Repository
public interface TUserDao {
	TUser queryByName(String userName);
}
