package knight.b0_mnt.entity;

import java.util.List;

/**
 * TMenu是TResource的变形类，用于生成Menu的树状结构
 * @author guoqt
 *
 */
public class TMenu {
	
	private List<TMenu> subMenu;
	
	private TResource res;

	public List<TMenu> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<TMenu> subMenu) {
		this.subMenu = subMenu;
	}

	public TResource getRes() {
		return res;
	}

	public void setRes(TResource res) {
		this.res = res;
	}

}
