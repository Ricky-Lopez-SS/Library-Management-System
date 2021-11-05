#Library Inserts
#Remember to dump tables!

INSERT INTO tbl_author VALUES (1,'Stephen King'),(2,'Giovanna Bellingham'),(3,'Giustina Minter'),(4,'Shaylah Cussen'),(5,'Patrica Bynert'),(6,'Wiley Szymaniak'),(7,'Benedikta Gethin'),(8,'Nevsa Annandale'),(9,'Justis Schuricht'),(10,'Seymour Kubec')

INSERT INTO tbl_publisher VALUES (1,'Rippin Inc','752 Graedel Circle','756-206-0758'),(2,'Graham LLC','92 Melvin Place','190-261-0953'),(3,'McGlynn, Welch and Dooley','9 Mariners Cove Street','938-258-2542'),(4,'Stiedemann, Zieme and Funk','6 Arkansas Terrace','575-304-7375'),(5,'Donnelly, Feest and McGlynn','630 Loeprich Court','450-168-3524'),(6,'Feeney-Bartoletti','38523 Steensland Court','834-822-0932'),(7,'Streich, Johnston and Carroll','8 Ronald Regan Center','449-938-9789'),(8,'Homenick, Abshire and Jacobson','310 Aberg Pass','461-513-2625'),(9,'Bins, Brown and Rogahn','917 Burning Wood Place','849-745-2771'),(10,'Paucek-Veum','4 Melody Hill','923-273-6046')

INSERT INTO tbl_genre VALUES (1, "Horror"), (2, "Fiction"), (3, "Romantic") , (4, "Romantic Comedy"), (5, "Adventure"), (6, "Mystery"), ( 7, "Fantasy"), (8, "Biography") , (9 , "Self-Help"), (10, "History"), (11, "Horror"), (12, 'Dystopian')

INSERT INTO tbl_borrower VALUES (1, 'Michael Tran', "1607 Merryweather Ln.", "9084747627"), (2, "Koauh Smith" , "6050 Russel Dr." , "8283450909") , (3, "Jefferson Dang", "11 Cool St." , "1102479018"), (4, "Micca Patang", "556 Memory Ln.", "4836472898"), (5, "Ricky Lopez", "230 Arthur St.", "9083279433")

INSERT INTO tbl_book VALUES (1, 'It', 4), (2, 'Carrie', 4), (3, 'Pet Sematary', 7), (4, 'Billy and Me', 3), (5, 'Eve of Man', 3), (6, 'Dread Nation', 1), (7, 'Deathless Divide', 9), (8, 'Vengeance Bound', 1), (9, 'Judge Me Not: Life of a Preacher\'s Child', 6), (10, 'A Remarkable Year', 4)

INSERT INTO `tbl_library_branch` VALUES (1,'Sharpstown','03169 Anhalt Circle'),(2,'Central','65204 Di Loreto Plaza'),(3,'Boyd','12 Shelley Plaza'),(4,'Arkansas','3138 Quincy Avenue'),(5,'Pierstorff','9262 Novick Way'),(6,'Prentice','19722 Cambridge Junction'),(7,'Derek','06340 Pennsylvania Alley'),(8,'Nelson','13 Northland Street'),(9,'Hoard','8 Nevada Way'),(10,'Dakota','5 Donald Terrace')

INSERT INTO tbl_book_authors VALUES (1, 1), (2, 1), (3, 1), (4, 2), (5, 2), (6, 3), (7, 3), (8, 3), (9, 4) , (10, 4);

INSERT INTO tbl_book_genres VALUES (11, 1), (11, 2), (11, 3), (3, 4), (3, 5), (12, 6), (12, 7), (7, 8), (8, 9), (8, 10), (2, 11);

INSERT INTO `tbl_book_copies` VALUES (1,4,100),(2,6,46),(3,4,35),(4,9,65),(5,2,40),(6,7,3),(7,3,83),(8,1,33),(9,6,69),(10,10,51);

