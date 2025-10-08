?dnom 
# Hàm mật độ: dnorm(x, mean, sd)
dnorm(4, mean = 0, sd = 1)
# Hàm mật độ f(x) tại x = 4 của 1 bnn x ~ N(0, 1)
dnorm(1:4, 98, 3.2)
x <- (-50:50)/12
plot(x, dnorm(x), type = 'l')
#Vẽ đồ thị hàm mật độ phân bố chuẩn tắc
## Hàm phân phối / hàm tích lũy: pnorm(q, mean, sd)
pnorm(2) # = pnorm(2,0,1):
#Tìm P(x<2) biết x ~N(0,1)
pnorm(3, 2, 1.1) # P(x <3) biết X~ N(2,1.1^2)
plot(x,pnorm(x), type = "l", main = "Hàm phân bố")
# Vẽ đồ thị hàm tích lũy pb chuẩn tắc
## Hàm phân vị: qnorm(p, mean, sd) : P(x<a) = p. Biết p, 
?qnorm()
qnorm(.05/2,0,1) #=qnorm(.05/2,1,0)
# Tìm a biết P(x<a) = 0.05/2, với x ~ N(0,1)
#P(X < -1.959964) = 0.05/2, với X ~ N(0,1)
qnorm(1-.05/2)
## Hàm mô phỏng / sinh mẫu ngẫu nhiên: norm(n, mean, sd): n laf soso 
?rnorm(4) 
rnorm(10,165,5)
# Biết chiều cao của bạn đó tuân theo phân phối chuẩn ~ N(
set.seed(12)
rnorm(10,100,5)

#2. Quan sát dữ liệu
library(MASS)
?Cars93
View(Cars93)
head(Cars93)
data = Cars93[ , c("Min.Price", "Price", "Max.Price", "MPG.highway", "Horsepower", "RPM")]
View(data)
hist(data$Price)
par(mfrow = c(3,2))
sapply(colnames(data), function(x) {
  hist(data[[x]], main = x)
})

dev.off()
hist(data$Price, freq = F, xlim = c(0,70), ylim = c(0, .07), xlab = "hihi", ylab = "haha", main = "Histogram")
?hist

qqnorm(data$Price)
qqline(data$Price)
par(mfrow = c(3,2))


z <- data$Price
ks.test(z, "pnorm", mean = mean(z), sd = sd(z))

?ks
?ks.test

install.packages("goftest")
library(goftest)
cvm.test(z, null = "pnorm", mean = mean(z), sd = sd(z))

install.packages("nortest")
library(nortest)
lillie.test(z)

shapiro.test(data$Price)

sample = rnorm(6)
sample
mean(sample)
var(sample)
sd(sample)
# Baif toan kliem dinh gttb 1 mau:
?t.test
t.test(sample)


sample2 = rnorm(5) + 1.5
t.test(sample, sample2)
t.test(sample, sample2, alt = "less", conf.level = 0.99)

