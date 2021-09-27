package com.example.customcontrollerarguments;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Part;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

class FileAttachmentArgumentResolver implements HandlerMethodArgumentResolver {

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.hasParameterAnnotation(XMLCONVERTOR.class);
  }

  @Override
  public Author resolveArgument(
      MethodParameter parameter,
      ModelAndViewContainer mavContainer,
      NativeWebRequest webRequest,
      WebDataBinderFactory binderFactory) {

	  Author author = null;
	try {
		Part part = ((ServletWebRequest) webRequest)
		  .getRequest().getPart("file");
		//part.getInputStream()
		JAXBContext jaxbContext = JAXBContext.newInstance(Author.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
		author = (Author) jaxbUnmarshaller.unmarshal(part.getInputStream()); 
		
	} catch (IOException | ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    
    return author;
  }
}