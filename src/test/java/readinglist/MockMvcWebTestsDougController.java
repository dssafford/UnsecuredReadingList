package readinglist;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ReadingListApplication.class)
@WebAppConfiguration
public class MockMvcWebTestsDougController {

	@Autowired
	WebApplicationContext webContext;
	private MockMvc mockMvc;

	@Before
	public void setupMockMvc() {
		mockMvc = MockMvcBuilders
				  .webAppContextSetup(webContext)
				  .build();
	}

	@Test
	public void redirectFromRoot() throws Exception {
		mockMvc.perform(get("/doug"))
				  .andExpect(status().is2xxSuccessful());


				  //.andExpect(header().string("Location", "/doug"));
	}



	@Test
	public void dougPage() throws Exception {
		mockMvc.perform(get("/doug"))
				  .andExpect(status().is2xxSuccessful())
				  .andExpect(view().name("doug"));


//				  .andExpect(model().attributeExists("books"))
//				  .andExpect(model().attribute("books", is(empty())));
	}

/*
	@Test
	public void postBook() throws Exception {
		mockMvc.perform(post("/readingList")
				  .contentType(APPLICATION_FORM_URLENCODED)
				  .param("title", "BOOK TITLE")
				  .param("author", "BOOK AUTHOR")
				  .param("isbn", "1234567890")
				  .param("description", "DESCRIPTION"))
				  .andExpect(status().is3xxRedirection())
				  .andExpect(header().string("Location", "/readingList"));

		Book expectedBook = new Book();
		expectedBook.setId(1L);
		expectedBook.setReader("craig");
		expectedBook.setTitle("BOOK TITLE");
		expectedBook.setAuthor("BOOK AUTHOR");
		expectedBook.setIsbn("1234567890");
		expectedBook.setDescription("DESCRIPTION");

		mockMvc.perform(get("/readingList"))
				  .andExpect(status().isOk())
				  .andExpect(view().name("readingList"))
				  .andExpect(model().attributeExists("books"))
				  .andExpect(model().attribute("books", hasSize(1)))
				  .andExpect(model().attribute("books",
							 contains(samePropertyValuesAs(expectedBook))));
	}
*/

}
