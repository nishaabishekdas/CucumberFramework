@CreateStore
Feature: Create Stores records using API

  @CreateStore @sanity 
  Scenario Outline: Create a multiple store record successfully
  	Given new store details are populated in request
  	#Given Include <name> and <address> in request
  	|name|type|address|address2|city|state|zip|lat|lng|hours|
  	|<name>|<type>|<address>|<address2>|<city>|<state>|<zip>|<lat>|<lng>|<hours>|
   	When the stores post endpoint is invoked 
    Then api should return the response code 201
   Examples:
   |name|type|address|address2|city|state|zip|lat|lng|hours|
  	|PivotStore|Bigbox|123 queen st||newyork|NY|14001|44.969658|-93.449539|"Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8"|
  	|TorontoStore|Bigbox|123 queen st||newyork|NY|14001|44.969658|-93.449539|"Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8"|
   