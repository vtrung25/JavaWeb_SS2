# Phan tich Scope va Race Condition - Bai tap 3

## 1) Vi sao thong bao loi dang nhap phai luu vao Request Scope?
- Thong bao loi dang nhap chi co y nghia cho request hien tai (lan submit form vua sai).
- Neu luu vao `request`, message se tu mat sau khi response ket thuc.
- Neu luu nham vao `session`, message se bi giu lai qua nhieu request va co the hien lai o cac trang khac, gay nhieu du lieu va trai nghiem sai.

## 2) Vi sao `totalViewCount` phai luu vao Application Scope?
- Yeu cau bai toan la tong luot xem tren toan he thong (tat ca nhan vien cung nhin mot so).
- `application` la vung du lieu dung chung cho tat ca session va request.
- Neu luu vao `session`, moi nhan vien se co bo dem rieng:
  - Nhan vien A co the thay 3
  - Nhan vien B co the thay 1
  -> sai nghiep vu "toan he thong".

## 3) Race Condition la gi va vi sao doan code duoi day nguy hiem?
```java
Integer count = (Integer) application.getAttribute("totalViewCount");
if (count == null) count = 0;
count++;
application.setAttribute("totalViewCount", count);
```

- Race Condition xay ra khi nhieu thread truy cap/cap nhat cung mot du lieu ma khong dong bo.
- Doan code tren la chuoi thao tac "doc -> tang -> ghi" khong atomic.
- Vi du 2 request cung doc duoc `count = 10`, ca hai cung tang len 11 va ghi lai 11.
- Ket qua mat 1 lan tang (dang ra phai la 12).

### Cach phong tranh da ap dung trong project
- Dong bo vung cap nhat bang lock rieng (`counterLock`) trong `OrderController`.
- Toan bo thao tac doc/tang/ghi duoc bao ve trong cung mot critical section.
- Nho do bo dem `totalViewCount` khong bi mat luot khi nhieu nguoi dung truy cap dong thoi.


