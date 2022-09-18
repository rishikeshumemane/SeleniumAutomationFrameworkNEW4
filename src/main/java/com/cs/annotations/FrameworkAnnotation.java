package com.cs.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.cs.enums.AuthorType;
import com.cs.enums.CategoryType;
import com.cs.enums.StoryId;

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotation {

	public CategoryType[] category()   default CategoryType.REGRESSION;
	public AuthorType[]    author()     default AuthorType.RISHI;
	public StoryId[]          story()      default StoryId.ENCOMPASS_1022;

}
