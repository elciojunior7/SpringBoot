INSERT INTO AUTOR (ID, NOME) VALUES
  (1, 'J. R. R. Tolkien'),
  (2, 'Arthur Conan Doyle');
  
INSERT INTO LIVRO (ID,NOME, QTDEPAGINAS, AUTOR_ID) VALUES
  (1, 'The Lord of the Rings',200, 1),
  (2, 'The Hobbit',300, 1),
  (3, 'Sherlock Holmes',400, 2);

INSERT INTO ROLE (ID, ROLE) VALUES
  (1, 'ROLE_BASIC'),
  (2, 'ROLE_ADMIN');