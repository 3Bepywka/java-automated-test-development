package com.acme.banking.dbo;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeTests.class)
@Suite.SuiteClasses( { SavingAccountTest.class, ClientTest.class })
public class SmokeTestSuite {
}
