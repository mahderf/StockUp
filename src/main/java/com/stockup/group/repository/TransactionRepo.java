package com.stockup.group.repository;

import com.stockup.group.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepo extends CrudRepository<Transaction, Long>{
}
