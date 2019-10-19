package com.example.demo.biz.service.domain;

import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private int id;
	@NotNull
	@Size(max = 20)
	private String name;
	@NotNull
	@Pattern(regexp = ".+@.+")
	private String emailAddress;
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;
	@Max(9)
	@Min(0)
	private Integer favoriteNumber;

	@AssertFalse(message = "{errors.emailAddress.ng}")
	public boolean isNgEmail() {
		if (emailAddress == null) {
			return true;
		}
		return !emailAddress.matches(".*@ng.foo.baz$");
	}
}
