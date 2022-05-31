package Junit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import login.AnswersBean;
import login.AnswersDao;

public class JunitAnswersDao {

	@Test
	public void findByQuestionsメソッドに1を入れる_戻り値答え() throws Exception{
		AnswersDao answersDao = new AnswersDao();
		AnswersBean answersBean = answersDao.findByQuestions(1).get(0);
		assertThat(answersBean.getAnswer(), is("めいち"));
	}

	@Test(expected = Exception.class)
	public void findByQuestionsメソッドにDBに存在しない問題番号を入れる_例外エラー() throws Exception{
		AnswersDao answersDao = new AnswersDao();
		answersDao.findByQuestions(8).get(0);
	}
	
	@Test
	public void findByQuestionsメソッドに1を入れる_戻り値id() throws Exception{
		AnswersDao answersDao = new AnswersDao();
		AnswersBean answersBean = answersDao.findByQuestions(1).get(0);
		assertThat(answersBean.getId(), is(1));
	}

	@Test(expected = Exception.class)
	public void findByQuestionsメソッドにマイナスの数値を入れる_例外エラー() throws Exception{
		AnswersDao answersDao = new AnswersDao();
		answersDao.findByQuestions(-1).get(0);
	}

}
