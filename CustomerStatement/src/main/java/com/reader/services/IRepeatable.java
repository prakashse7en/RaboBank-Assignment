package com.reader.services;

import java.util.List;

import com.reader.model.CustomerStatement;

public interface IRepeatable {

	public abstract void print(List<CustomerStatement> customerStatementList);
}
