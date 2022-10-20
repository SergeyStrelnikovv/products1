package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {

  ProductRepository productRepository = new ProductRepository();
  ProductManager productManager = new ProductManager(productRepository);

  Book book1 = new Book(1, "book1", 100, "author1");
  Book book2 = new Book(2, "book2", 200, "author2");
  Book book3 = new Book(3, "book3", 300, "author3");
  Book book4 = new Book(4, "book4", 100, "author4");

  Smartphone smartphone1 = new Smartphone(5, "smartphone1", 100_000, "manufacturer1");
  Smartphone smartphone2 = new Smartphone(6, "smartphone2", 99_999, "manufacturer2");
  Smartphone smartphone3 = new Smartphone(7, "smartphone3", 12_345, "manufacturer3");
  Smartphone smartphone4 = new Smartphone(8, "smartphone4", 15_000, "manufacturer4");


  @BeforeEach
  public void addProduct() {
    productManager.add(book1);
    productManager.add(book2);
    productManager.add(book3);
    productManager.add(book4);
    productManager.add(smartphone1);
    productManager.add(smartphone2);
    productManager.add(smartphone3);
    productManager.add(smartphone4);
  }

  @Test
  public void shouldSearchBySmartphoneName() {
    Product[] results = productManager.searchBy("smartphone");
    Product[] expected = new Product[]{smartphone1, smartphone2, smartphone3, smartphone4};
    assertArrayEquals(expected, results);
  }

  @Test
  public void shouldSearchByBookName() {
    Product[] results = productManager.searchBy("book");
    Product[] expected = new Product[]{book1, book2, book3, book4};
    assertArrayEquals(expected, results);
  }

  @Test
  public void shouldSearchByDiffName() {
    Product[] results = productManager.searchBy("TShirt");
    Product[] expected = new Product[0];
    assertArrayEquals(expected, results);
  }

  @Test
  public void shouldSearchByManufacturer() {
    Product[] results = productManager.searchBy("manufacturer");
    Product[] expected = new Product[]{smartphone1, smartphone2, smartphone3, smartphone4};
    assertArrayEquals(expected, results);
  }

  @Test
  public void shouldSearchByAuthorName() {
    Product[] results = productManager.searchBy("author");
    Product[] expected = new Product[]{book1, book2, book3, book4};
    assertArrayEquals(expected, results);
  }
}