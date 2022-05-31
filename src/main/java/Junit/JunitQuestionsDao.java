package Junit;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import login.QuestionsBean;
import login.QuestionsDao;

public class JunitQuestionsDao {

	@Test
	public void findメソッドに1を入れる_戻り値問題文() throws Exception{
		QuestionsDao questionsDao = new QuestionsDao();
		assertThat(questionsDao.find(1).getQuestion(), is("「明知」の読み方を答えよ"));
	}

	@Test
	public void findメソッドにDBに存在しない問題番号を入れる_戻り値問題文null() throws Exception{
		QuestionsDao questionsDao = new QuestionsDao();
		assertThat(questionsDao.find(999).getQuestion(), nullValue());
	}
	
	@Test
	public void findメソッドにマイナスの数値を入れる_戻り値null() throws Exception{
		QuestionsDao questionsDao = new QuestionsDao();
		assertThat(questionsDao.find(-1).getQuestion(), nullValue());
	}
	
	@Ignore
	@Test
	public void registerメソッドに新規の問題文を入れる_戻り値問題Noの最大値() throws Exception{
		QuestionsDao questionsDao = new QuestionsDao();
		//findAll()で全件取得
		ArrayList<QuestionsBean> questionBean = questionsDao.findAll();
		int maxId = questionBean.get(0).getId();
		//リスト内のidの最大値を取り出したい
		for(int i = 0; i < questionBean.size(); i++) {
			if(maxId < questionBean.get(i).getId()) {
				maxId = questionBean.get(i).getId();
			}
		}
		//リスト内の最大値にプラス1すれば、新規登録した問題Noとイコールになるはず
		assertThat(questionsDao.register("あいうえお"),is(maxId + 1));
	}
	
	@Test(expected = Exception.class)
	public void registerメソッドにnullを入れる_例外エラー() throws Exception{
		QuestionsDao questionsDao = new QuestionsDao();
		questionsDao.register(null);
	}
	
	@Test
	public void registerメソッドにスペースを入れる_戻り値0() throws Exception{
		QuestionsDao questionsDao = new QuestionsDao();
		assertThat(questionsDao.register(" "), is(0));
	}
	
	@Test
	public void deleteQuestionsメソッドに問題Noを入れる_戻り値1() throws Exception{
		QuestionsDao questionsDao = new QuestionsDao();
		assertThat(questionsDao.deleteQuestion(39), is(1));
	}
	
	@Test
	public void deleteQuestionsメソッドにマイナスの数値を入れる_戻り値0() throws Exception{
		QuestionsDao questionsDao = new QuestionsDao();
		assertThat(questionsDao.deleteQuestion(-1), is(0));
	}
	
	@Test
	public void deleteAnswerメソッドに問題Noを入れる_戻り値1() throws Exception{
		QuestionsDao questionsDao = new QuestionsDao();
		assertThat(questionsDao.deleteAnswer(39), is(1));
	}
	
	@Test
	public void deleteAnswerメソッドにマイナスの数値を入れる_戻り値0() throws Exception{
		QuestionsDao questionsDao = new QuestionsDao();
		assertThat(questionsDao.deleteAnswer(-1), is(0));
	}
	
	
}
