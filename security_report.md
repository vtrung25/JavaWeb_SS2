# Bao cao bao mat - Bai tap 4

## 1) XSS la gi? Vi sao `c:out` an toan hon `${keyword}`?
- XSS (Cross-Site Scripting) la lo hong cho phep ke tan cong chen JavaScript doc hai vao noi dung trang web.
- Neu in truc tiep `${keyword}` trong mot so ngu canh output, trinh duyet co the dien giai the HTML/JS thay vi hien thi text.
- `c:out` voi `escapeXml="true"` se encode ky tu dac biet (`<`, `>`, `&`, `"`, `'`) thanh entity HTML.

### So sanh output khi input la `<script>alert(1)</script>`
- In khong escape (nguy hiem):
```html
<script>alert(1)</script>
```
- In qua `c:out` (an toan):
```html
&lt;script&gt;alert(1)&lt;/script&gt;
```
=> Trinh duyet hien thi chuoi thuong, khong thuc thi JavaScript.

## 2) Khac nhau giua `c:if` va `c:choose/c:when/c:otherwise`
- `c:if`: dung cho dieu kien don le, co the khong render gi neu dieu kien sai.
- `c:choose`: tuong duong if/else-if/else, dam bao nhieu nhanh loai tru nhau va ro rang logic.

### Trong bai nay nen dung gi?
- Phan **Gia ve** nen dung `c:choose`:
  - `price == 0` -> badge "MIEN PHI"
  - nguoc lai -> `fmt:formatNumber`
- Phan **Ve con lai** cung nen dung `c:choose`:
  - `== 0` -> "HET VE"
  - `< 10` -> "Sap het"
  - nguoc lai -> hien thi binh thuong

Vi day la bo dieu kien nhieu nhanh, `c:choose` ro va de bao tri hon nhieu `c:if` rieng le.

## 3) `c:url` giai quyet van de gi so voi hardcode href?
- Hardcode `href="/events/1/book"` mac dinh app o root context `/`.
- Khi deploy app vao context khac (vi du `/ticketing`), link hardcode se sai duong dan.
- `c:url` tu dong gan context path dung cua ung dung.

### Vi du
- Deploy root `/`: `/events/1/book`
- Deploy `/ticketing`: `/ticketing/events/1/book`

Voi `c:url`, cung mot JSP van chay dung o nhieu moi truong deploy ma khong phai sua tay link.

