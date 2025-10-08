# Cau 1:
#Vecto x
x = c(1:9)
x
#Vecto y
y = c(1.5,2.3,3.2,4.6,5.4,6.6,7.6,8.6,9.1)
y

#Do dai vecto X
length(x)
#Do dai vecto y 
length(y)

#Tong 2 vecto
x + y
#Hieu cua 2 vecto
x - y
#Tich cua 2 vecto
x * y
# Chuan cua 2 vecto
sqrt(sum(x^2)); sqrt(sum(y^2))
#Trích ra phần tử thứ 1,3,5 trong vector X, và phần tử không phải thứ 4,5,6 trong vectoY
x[c(1,3,5)]
y[-c(4,5,6)]
#Thay giá trị phần tử cuối cùng của X bởi tích các phần tử còn lại.
x[9] <- prod(x[-9])
x
#  Thay giá trị của phần tử thứ 2 và thứ 7 của Y bởi 99 và 199.
y[c(2,7)] <- c(99,199)
y
# Làm tròn các phần tử của Y 2 đến hàng đơn vị.
round(y)

#Cau 2:
# a. Đổi tên các hàng của ma trận A theo thứ tự lần lượt là “X”, “Y”, “Z”, “T” và các cột là "A","B","C","D"..
# Định nghĩa ma trận A và B
A <- matrix(c(
  1,3,2,8,
  2,6,4,7,
  1,5,3,5,
  3,4,2,1
), nrow = 4, byrow = TRUE)
B <- matrix(c(
  1,4,1,4,
  2,1,7,6,
  3,5,8,3,
  4,3,9,7
), nrow = 4, byrow = TRUE)
cat("Ma trận A:\n"); print(A)
cat("\nMa trận B:\n"); print(B)

# (a) Đổi tên hàng/cột của A
rownames(A) <- c("X", "Y", "Z", "T")
colnames(A) <- c("A","B","C","D")
cat("\n(a) A với tên hàng/cột:\n"); print(A)
# (b) Tổng các phần tử theo hàng/cột của B; trung bình theo hàng/cột của A
row_sums_B <- rowSums(B)
col_sums_B <- colSums(B)
row_means_A <- rowMeans(A)
col_means_A <- colMeans(A)

cat("\n(b) Tổng theo hàng của B:\n"); print(row_sums_B)
cat("Tổng theo cột của B:\n"); print(col_sums_B)
cat("\nTrung bình theo hàng của A:\n"); print(row_means_A)
cat("Trung bình theo cột của A:\n"); print(col_means_A)

# (c) "Đưa ra giá trị ở hàng 2 và không ở cột 3 của ma trận A"
# (tức là lấy hàng 2 rồi loại bỏ cột 3)
row2_not_col3 <- A["Y", -which(colnames(A)=="C")]
cat("\n(c) Hàng 2 của A bỏ cột 3 (các phần tử):\n"); print(row2_not_col3)

# (d) Ma trận D = hàng 1 & hàng 2 của A; E = B bỏ cột 3
D <- A[c("X","Y"), , drop = FALSE]
E <- B[, -3, drop = FALSE]
cat("\n(d) D (2x4) — hàng 1 & 2 của A:\n"); print(D)
cat("\nE (4x3) — B bỏ cột 3:\n"); print(E)

# (e) Chuyển vị và nghịch đảo của A
A_t <- t(A)
# Lưu ý: A đổi tên hàng/cột; để tính nghịch đảo ta dùng ma trận số tương ứng
A_numeric <- unname(A)  # loại bỏ tên để solve cho rõ
if (det(A_numeric) == 0) {
  cat("\n(e) A không khả nghịch (determinant = 0)\n")
  A_inv <- NULL
} else {
  A_inv <- solve(A_numeric)
  cat("\n(e) A^T:\n"); print(A_t)
  cat("\nA^-1 (làm tròn 6 chữ số):\n"); print(A_inv)
}

# (f) Giá trị riêng, vectơ riêng của B; định thức của B
eigB <- eigen(B)
eigvals_B <- eigB$values
eigvecs_B <- eigB$vectors
det_B <- det(B)

cat("\n(f) Eigenvalues của B:\n"); print(eigvals_B)
cat("Eigenvectors (cột tương ứng):\n"); print(eigvecs_B)
cat("\nDeterminant của B:\n"); print(det_B)

# (g) Tính A^{-1} B^T
if (!is.null(A_inv)) {
  Ainv_BT <- A_inv %*% t(B)
  cat("\n(g) A^{-1} %*% B^T (làm tròn 6 chữ số):\n"); print(Ainv_BT)
} else {
  cat("\n(g) Không thể tính A^{-1} B^T vì A không khả nghịch\n")
}

# (h) Tìm Z sao cho A (Z - I) = B  =>  A Z = B + A  => Z = A^{-1} (B + A)
if (!is.null(A_inv)) {
  Z <- A_inv %*% (B + unname(A))  # đảm bảo cùng dạng số
  cat("\n(h) Ma trận Z = A^{-1} (B + A) (làm tròn 6 chữ số):\n"); print(Z)
} else {
  cat("\n(h) Không thể tính Z vì A không khả nghịch\n")
}

# (i) Ma trận G là ma trận đối xứng có tam giác trên giống A
# Lấy tam giác trên (bao gồm đường chéo) của A_numeric rồi đối xứng hóa
A_upper <- matrix(0, nrow = 4, ncol = 4)
for (i in 1:4) for (j in i:4) A_upper[i,j] <- A_numeric[i,j]
G <- A_upper + t(A_upper) - diag(diag(A_upper))  # đối xứng, bảo đường chéo không nhân đôi
cat("\n(i) Ma trận G (đối xứng, tam giác trên giống A):\n"); print(G)

# Kiểm tra tính xác định dương: kiểm tra trị riêng > 0
eigG <- eigen(G)
cat("\nTrị riêng của G:\n"); print(eigG$values)
is_positive_definite_G <- all(eigG$values > 0)
cat("G có phải là ma trận xác định dương không? ->", is_positive_definite_G, "\n")

# (j) Xét H = det(B)^{-1} * B; H có phải ma trận trực giao không?
if (abs(det_B) < .Machine$double.eps) {
  cat("\n(j) det(B) = 0, không thể chia để tạo H\n")
} else {
  H <- (1/det_B) * B
  cat("\n(j) Ma trận H = B / det(B):\n"); print(H)
  # Kiểm tra trực giao: H^T H == I ?
  HT_H <- t(H) %*% H
  cat("\nH^T %*% H (làm tròn 6 chữ số):\n"); print(HT_H)
  is_orthogonal_H <- isTRUE(all.equal(HT_H, diag(4), tolerance = 1e-8))
  cat("H có phải là ma trận trực giao không? ->", is_orthogonal_H, "\n")
}

  