package com.jaxrs;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.jaxrs.controller.ArticleInfo;
//import com.jaxrs.entity.Article;
//import com.jaxrs.repository.Articlerepository;
//import com.jaxrs.service.ArticleService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
public class ArticleServiceTest {
//	
//	@Mock
//	private Articlerepository articlerepo;
//private MockMvc mockMvc;
//	
//	@Autowired
//	private WebApplicationContext wac;
//	
//	@InjectMocks
//	private ArticleService articleservice;
//	
//	@Before
//	public void setup() {
//		MockitoAnnotations.initMocks(this);
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//	}
//	
//	
//
//	
//	@Test
//	public void testGetAllArticles() {
//		
//		List<Article> articleList = new ArrayList<Article>();
//		
//		articleList.add(new Article(1,"Rest Micro services"," REST" ));
//		articleList.add(new Article(2,"Rest Micro services1"," REST1" ));
//		articleList.add(new Article(3,"Rest Micro services2"," REST2" ));
//		
//		when(articlerepo.findAll()).thenReturn(articleList);
//		List<Article> result = articleservice.getAllArticles();
//		assertEquals(3, result.size());
//		
//	}
//	
//	@Test
//	public void saveArticles() {
//		Article article = new Article(1, "Some Book","Some category");
//		Optional<Article> returnValue = Optional.of((Article) article);
//		//Mockito.<Optional<Article>>when(articlerepo.findById((long)1)).thenReturn(article);
//		
//		
//	}
//	
//
}
