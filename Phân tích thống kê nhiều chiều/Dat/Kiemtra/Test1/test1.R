data()
install.packages("ISLR")
library(ISLR)
data("Carseats")
head(Carseats)
View(Carseats)
Carseats$Income[168]

# Hiện tại chưa sửa nhân 2 ma trận đâu, đang sai đó nhân 2 ma trận phải dùng %*%

a = as.matrix(Carseats[c(13,47,97, 136), c("Sales", "CompPrice", "Income", "Price")])
a
det(a)


a = as.matrix(Carseats[c(13,47,97, 16), c("Sales", "CompPrice", "Income", "Advertising")])

a = t(a)
a[1,4]


a = as.matrix(Carseats[c(11,14,190, 212), c("Sales", "CompPrice", "Income", "Age")])
b = as.matrix(Carseats[c(113,147,197, 136), c("Sales", "CompPrice", "Income", "Price")])

c = b * a
c
c[2, 4]

x = Carseats$Age[c(36:71)]
x
y = Carseats$Age[c(136:171)]
y
a = matrix(x, nrow = 6, ncol = 6, byrow = T)
a
b = matrix(y, nrow = 6, byrow = F)
b
c = a + b
c
c[3,2]


d = as.matrix(Carseats[c(113,147,197, 136), c("Sales", "CompPrice", "Income", "Price")])
d
e = solve(d)
e[3,2]
round(e[3,2], 3)

a = as.matrix(Carseats[c(13,47,97, 136), c("Sales", "CompPrice", "Income", "Advertising")])
a
b = as.matrix(Carseats[c(13,47,97, 16), c("Sales", "CompPrice", "Income", "Price")])
b
c = as.matrix(Carseats[c(13,141,88, 259), c("Sales", "CompPrice", "Income", "Age")])
c
d = solve(b)*solve(a)*c
d
round(d[1,2],3)
a = Carseats$Advertising
length(a)

a = as.matrix(Carseats[c(13,47,197, 136), c("Sales", "CompPrice", "Income", "Advertising")])
a
b = as.matrix(Carseats[c(13,47,97, 16), c("Sales", "CompPrice", "Income", "Price")])
b
c=a-b
c[3,2]


c = solve(b) * a
round(c[3,1],3)
