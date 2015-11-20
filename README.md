# Omise Java Client

## Requirements

* Java 1.6 and up.
* [GSON](https://code.google.com/p/google-gson/) version 2.2.4 and up.

Using older version of the requirements may work, but it is not officially supported.

## Installation

If you use Maven, you can add Omise as a dependency.

```
<dependency>
  <groupId>co.omise</groupId>
  <artifactId>omise-java</artifactId>
  <version>1.0.6</version>
</dependency>
```

If you use Gradle, you can add Omise as a dependency.

```
compile 'co.omise:omise-java:1.0.6'
```

### Manually

If you don't use Maven, you can simply clone the library into your project directory:

```
git clone https://github.com/omise/omise-java
```

## Usage

First, please set the secret and public keys:

```java
import co.omise.Omise;

Omise.setKeys("pkey_test_XXXXXXXXXXXXXXXXX", "skey_test_XXXXXXXXXXXXXXXXX");
```

Please then refer to [Omise Documentation](https://docs.omise.co/) for more information on API usage. As an example, to create a customer:

```java
import co.omise.model.Customer;

Customer customer = Customer.create(new HashMap<String, Object>() {
        {put("email", "john.doe@example.com");}
        {put("description", "John Doe (id: 30)");}
        {put("card", "tokn_test_4xs9408a642a1htto8z");}
    });
```

To retrieve the created customer, then update and delete it:

```java
import co.omise.model.Customer;
import co.omise.model.DeleteCustomer;

Customer customer = Customer.retrieve("cust_test_4xtrb759599jsxlhkrb");
customer.update(new HashMap<String, Object>() {
        {put("email", "john.smith@example.com");}
        {put("description", "Another description");}
    });
DeleteCustomer deleteCustomer = customer.destroy();
deleteCustomer.isDestroyed(); // => true
```

## Testing

To run an automated test suite, first replace your keys in `test.java.co.omise.OmiseSetting.java`:

```java
Omise.setKeys("pkey_test_XXXXXXXXXXXXXXXXX", "skey_test_XXXXXXXXXXXXXXXXX");
```

Then run JUnit with Maven:

```
mvn test
```

## License

See LICENSE.txt
