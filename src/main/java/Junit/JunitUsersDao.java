package Junit;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import login.UsersDao;

public class JunitUsersDao {
	
	@Test
	public void findメソッドにDBに存在するユーザーIDを入れる_戻り値ユーザー名() throws Exception{
		UsersDao usersDao = new UsersDao();
		assertThat(usersDao.find(2).getName(), is("meichi"));
	}
	
	@Test
	public void findメソッドにDBに存在しないユーザーIDを入れる_戻り値ユーザー名() throws Exception{
		UsersDao usersDao = new UsersDao();
		assertThat(usersDao.find(999).getName(), nullValue());
	}
	
	@Test
	public void findメソッドにDBに存在するユーザーIDを入れる_戻り値PW() throws Exception{
		UsersDao usersDao = new UsersDao();
		assertThat(usersDao.find(2).getPassword(), is("meichi"));
	}
	
	@Test
	public void findメソッドにDBに存在しないユーザーIDを入れる_戻り値PW() throws Exception{
		UsersDao usersDao = new UsersDao();
		assertThat(usersDao.find(999).getPassword(), nullValue());
	}
	
	
	@Test
	public void findメソッドにマイナスの数値を入れるとnull() throws Exception{
		UsersDao usersDao = new UsersDao();
		assertThat(usersDao.find(-1).getPassword(),nullValue());
	}
	
	@Test
	public void findNameメソッドにDBに存在するユーザー名を入れる_戻り値ID() throws Exception{
		UsersDao usersDao = new UsersDao();
		assertThat(usersDao.findName("meichi").getId(), is(2));
	}
	
	@Test
	public void findNameメソッドにDBに存在しないユーザー名を入れる_戻り値ID() throws Exception{
		UsersDao usersDao = new UsersDao();
		assertThat(usersDao.findName("aiueo").getId(), is(0));
	}
	
	@Test
	public void findNameメソッドにDBに存在するユーザー名を入れる_戻り値PW() throws Exception{
		UsersDao usersDao = new UsersDao();
		assertThat(usersDao.findName("meichi").getPassword(), is("meichi"));
	}
	
	@Test
	public void findNameメソッドにDBに存在しないユーザー名を入れる_戻り値PW() throws Exception{
		UsersDao usersDao = new UsersDao();
		assertThat(usersDao.findName("aiueo").getPassword(), nullValue());
	}	
		
	@Test
	public void findNameメソッドにnullを入れる_戻り値null() throws Exception{
		UsersDao usersDao = new UsersDao();
		assertThat(usersDao.findName(null).getPassword(), nullValue());
	}
	
	@Test
	public void findNameメソッドにスペースを入れる_戻り値null() throws Exception{
		UsersDao usersDao = new UsersDao();
		assertThat(usersDao.findName(" ").getPassword(), nullValue());
	}

	
}
