package org.sang;

import org.sang.bean.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Test19SpringBoot3Application {

	public static void main(String[] args) {
		/*SpringApplication.run(Test19SpringBoot3Application.class, args);*/

		SpringApplicationBuilder builder = new SpringApplicationBuilder(Test19SpringBoot3Application.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);

	}

	@Value(value = "${book.author}")
	private String bookAuthor;
	@Value(value = "${book.name}")
	private String bookName;
	@Value(value = "${book.pinyin}")
	private String bookPinyin;

	@RequestMapping(value = "/" , produces = "text/plain;charset=UTF-8")
	String index(){
		String in =bookAuthor.concat(bookPinyin);
		String inTwo = in.concat(bookName);
		return "Hello Spting boot"+inTwo ;
	}

    @Autowired
    private BookBean bookBean;
    @RequestMapping("/books")
    public String book(){
        return "----"+bookBean.getAuthor()+"---"+bookBean.getName();
    }
}
