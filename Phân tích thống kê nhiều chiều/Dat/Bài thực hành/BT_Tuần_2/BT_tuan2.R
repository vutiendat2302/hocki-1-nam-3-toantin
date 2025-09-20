# Câu 1: 
install.packages("MASS")
library(MASS)

data(hills)
View(hills)
head(hills)

#a. Tìm giá trị trung bình và độ lệch tiêu chuẩn của độ dài đường đua,
#độ cao đạt được và thời gian chạy của người chiến thắng
?colMeans
print("Giá trị trung bình")
colMeans(hills)
apply(hills, 2, mean)
print("Độ lệch tiêu chuẩn")
# a <- hills$dist
# sd(a)
?apply
apply(hills, 2, sd)

#b Các biến trong bộ dữ liệu có tuân theo phân phối chuẩn hay không ?
par(mfrow=c(3,2))
hist(hills$dist, main = "Histogram dist", xlab = "Distance")
qqnorm(hills$dist)
qqline(hills$dist, col = "red")

hist(hills$climb, main = "Histogram climb", xlab = "Climb")
qqnorm(hills$climb)
qqline(hills$climb, col = "red")

hist(hills$time, main = "Histogram time", xlab = "time")

qqnorm(hills$time)
qqline(hills$time, col = "red")

dev.off()

# Kiểm định Shapiro-Wilk
shapiro.test(hills$dist)
print("Do p-value < 0.05 nên bác bỏ H0 => Dist không tuân theo phân phối chuẩn")
shapiro.test(hills$climb)
print("Do p-value < 0.05 nên bác bỏ H0 => Climb không tuân theo phân phối chuẩn")
shapiro.test(hills$time)
print("Do p-value < 0.05 nên bác bỏ H0 => Time không tuân theo phân phối chuẩn")


# Dùng hàm Pairs để vẽ ma trận biểu đồ tán xạ cho bộ dữ liệu.
pairs(hills, main = "Scatterplot matrix of hills dataset")

print("Nhận xét: dist ~ time, climb ~ time")

model <- lm(time ~ dist + climb, data = hills)
resid_sq <- residuals(model)^2

shapiro.test(resid_sq)
qqnorm(resid_sq); qqline(resid_sq, col="red")
print("Do p-value < 0.05 nên bác bỏ H0 => bình phương hiệu số không tuân theo phân phối chuẩn")

print("------------------------")
#Câu 2: 
head(iris)
#a. Tìm giá trị trung bình và độ lệch tiêu chuẩn của độ dài, độ rộng cánh hoa và đài hoa
# Giá trị trung bình
colMeans(iris[,1:4])
# Độ lệch chuẩn
apply(iris[,1:4], 2, sd)

#b. Các biến trong bộ dữ liệu có tuân theo phân phối chuẩn không?
shapiro.test(iris$Sepal.Length)
print("Do p-value < 0.05 nên bác bỏ H0 => Độ dài cánh hoa không tuân theo phân phối chuẩn")
shapiro.test(iris$Sepal.Width) 
print("Do p-value < 0.05 nên bác bỏ H0 => Độ rộng cánh hoa không tuân theo phân phối chuẩn")
shapiro.test(iris$Petal.Length)
print("Do p-value < 0.05 nên bác bỏ H0 => Độ dài đài hoa không tuân theo phân phối chuẩn")
shapiro.test(iris$Petal.Width)
print("Do p-value < 0.05 nên bác bỏ H0 => Độ rộng đài hoa không tuân theo phân phối chuẩn")

#c. Vẽ đồ thị hàm mật độ và hàm phân phối của các biến có phân phối chuẩn trên cùng
#một khung hình. Đặt tên đồ thị, tên và độ dài các trục phù hợp.
print("Không biến nào có phân phối chuẩn")
par(mfrow=c(1,2))
plot(density(iris$Sepal.Length), 
     main="Hàm mật độ",
     xlab="Sepal.Length", ylab="Density")

plot(ecdf(iris$Sepal.Length),
     main="Hàm phân phối",
     xlab="Sepal.Length", ylab="F(x)")

#d. Với mức ý nghĩa 5%, có thể nói độ rộng trung bình của đài hoa nhỏ hơn 3.5 không?
t.test(iris$Sepal.Width, mu = 3.5, alternative = "less")

print("Do p-value < 0.05 nên bác bỏ H0 -> Độ rộng trung bình của đài hoa nhỏ hơn 3.5")

#e. Tìm a, biết xác suất để độ rộng đài hoa nhỏ hơn a là 70%.
a <- quantile(iris$Sepal.Width, 0.7)
a

#f. Độ rộng trung bình của đài hoa của loài setosa và versicolor có thực sự khác nhau
# không? Mức ý nghĩa 1%.

setosa <- iris$Sepal.Width[iris$Species=="setosa"]
versicolor <- iris$Sepal.Width[iris$Species=="versicolor"]

t.test(setosa, versicolor, alternative = "two.sided", var.equal = TRUE, conf.level = 0.99)
print("Do p-value < 0.05 => bác bỏ H0, Độ rộng trung bình đài hoa của setosa và versicolor là khác nhau với mức ý nghĩa 1%")

print("-------------------------")

# Câu 3:
set.seed(12)
n <- 20
m <- 30
kv <- 158
dlc <- sqrt(8)

# Sinh 30 mẫu ngẫu nhiên,
data <- replicate(m, rnorm(n, mean = kv, sd = dlc), simplify = FALSE)
data

# Mẫu thứ bao nhiêu có khoảng tin cậy rộng nhất/hẹp nhất?
ktc <- function(x, alpha = 0.02) {
  xbar <- mean(x)
  s <- sd(x)
  n <- length(x)
  error <- qt(1 - alpha/2, df = n-1) * s / sqrt(n)
  c(lower = xbar - error, upper = xbar + error, mean = xbar)
}

cis <- t(sapply(data, ktc))
print(cis)

widths <- cis[, "upper"] - cis[, "lower"]
cat("Mẫu rộng nhất:", which.max(widths), "\n")
cat("Mẫu hẹp nhất:", which.min(widths), "\n")


# c. Mẫu có mean lớn nhất
max_idx <- which.max(cis[, "mean"])
cat("Mẫu thứ", max_idx, "có giá trị trung bình lớn nhất\n")

#d. 
# Vẽ các khoảng tin cậy ở ý (i) thỏa mãn các khoảng đó chứa giá trị trung bình của mẫu
# gồm toàn bộ các quan sát trong 30 mẫu ngẫu nhiên được sinh ban đầu. Ký hiệu hai
# đầu mút mỗi khoảng bằng chấm tròn đỏ, độ dài khoảng có màu xanh lá cây; đặt tên
# đồ thị là "Khoảng tin cậy cho GTTB của các mẫu ngẫu nhiên", trục Ox là "Khoảng
# tin cậy cho GTTB", trục Oy là "Các mẫu ngẫu nhiên".

plot(NULL, xlim = range(cis[, c("lower","upper")]), ylim = c(1, m),
     xlab = "Khoảng tin cậy cho GTTB", ylab = "Các mẫu ngẫu nhiên",
     main = "Khoảng tin cậy cho GTTB của các mẫu ngẫu nhiên")

for (i in 1:m) {
  segments(cis[i, "lower"], i, cis[i, "upper"], i, col = "green", lwd = 2)
  points(cis[i, c("lower","upper")], c(i,i), col = "red", pch = 19)
}

print("-------------------")

