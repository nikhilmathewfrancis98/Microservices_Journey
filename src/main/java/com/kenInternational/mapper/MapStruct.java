package com.kenInternational.mapper;

import com.kenInternational.Entity.User;
import com.kenInternational.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * This is the mapStruct interface and the implementation will be taken care by the mapStruct on
 * compile time. Also we need to get the impl class we need to add a code here
 * or we have to write an impl class , or we need to write the anonymous class to get the object to
 * execute these methods
 */

@Mapper
public interface MapStruct {
//    MapStruct Mapper= Mappers.getMapper(MapStruct.class);
//    @Mapping(source = "{fName,lName}",target = "{fName,lName}") //This is used inorder to make the field name map differ in name
    UserDto mapStructUserToDTO(User user);
    User mapStructDTOToUser(UserDto userDTO);


}


/**
 * Anonymous inner class implementation
 * public class HelloWorldAnonymousClasses {
 *
 *     interface HelloWorld {
 *         public void greet();
 *         public void greetSomeone(String someone);
 *     }
 *
 *     public void sayHello() {
 *
 *         class EnglishGreeting implements HelloWorld {
 *             String name = "world";
 *             public void greet() {
 *                 greetSomeone("world");
 *             }
 *             public void greetSomeone(String someone) {
 *                 name = someone;
 *                 System.out.println("Hello " + name);
 *             }
 *         }
 *
 *         HelloWorld englishGreeting = new EnglishGreeting();
 *
 *         HelloWorld frenchGreeting = new HelloWorld() {
 *             String name = "tout le monde";
 *             public void greet() {
 *                 greetSomeone("tout le monde");
 *             }
 *             public void greetSomeone(String someone) {
 *                 name = someone;
 *                 System.out.println("Salut " + name);
 *             }
 *         };
 *
 *         HelloWorld spanishGreeting = new HelloWorld() {
 *             String name = "mundo";
 *             public void greet() {
 *                 greetSomeone("mundo");
 *             }
 *             public void greetSomeone(String someone) {
 *                 name = someone;
 *                 System.out.println("Hola, " + name);
 *             }
 *         };
 *         englishGreeting.greet();
 *         frenchGreeting.greetSomeone("Fred");
 *         spanishGreeting.greet();
 *     }
 *
 *     public static void main(String... args) {
 *         HelloWorldAnonymousClasses myApp =
 *             new HelloWorldAnonymousClasses();
 *         myApp.sayHello();
 *     }
 * }
 */