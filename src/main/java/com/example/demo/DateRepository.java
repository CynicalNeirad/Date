package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface DateRepository  extends CrudRepository<AppDate,Long> {
    Iterable<AppDate> findAllByDateUser(AppUser user);
}
