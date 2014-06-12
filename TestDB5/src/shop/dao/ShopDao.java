package shop.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import shop.beans.ShopValueObject;
import shop.dao.DaoConnect;
public class ShopDao extends DaoConnect{
	public List<ShopValueObject> shopList() throws Exception{
		List<ShopValueObject> resultList = new ArrayList<ShopValueObject>();
		String sql = "SELECT sname, sprice, snum FROM shop_list";
		//���sSQL��n��
		PreparedStatement statement = connection.prepareStatement(sql);
		//���ʂ��擾
		ResultSet rs = statement.executeQuery();
		//�������ʂ̍s�����A�擾���ʂ��i�[
		while (rs.next()){
			ShopValueObject s = new ShopValueObject();
			s.setSname(rs.getString("sname"));
			s.setSprice(rs.getInt("sprice"));
			s.setSnum(rs.getInt("snum"));
			resultList.add(s);
		}
		return resultList;
	}
}