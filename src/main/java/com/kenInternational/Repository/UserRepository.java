package com.kenInternational.Repository;

import com.kenInternational.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * here we don't need to annotate with the @Repository cause it internally uses the @repo annot in their
 * imp interfaces
 */
public interface UserRepository  extends JpaRepository<User,Long> {
}
