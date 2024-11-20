gender=c(rep("male",400),rep("female",600))
vote=c(rep("repub",200),rep("demo",150),rep("ind",50),rep("repub",250),rep("demo",300),rep("ind",50))

data=data.frame(gender,vote)

table(data) #note alphabetical ordering

chisq.test(table(data),correct = F)
test=chisq.test(table(data),correct = F)

test
test$observed
test$expected
(test$observed-test$expected)^2/test$expected

ts=sum((test$observed-test$expected)^2/test$expected)
df=(3-1)*(2-1)

1-pchisq(ts,df)

###############

#voter1 <- read.csv("~/Desktop/voter1.csv")
table(voter1)

test=chisq.test(table(voter1),correct = F)
test
test$observed
test$expected
(test$observed-test$expected)^2/test$expected
ts=sum((test$observed-test$expected)^2/test$expected)
df=(2-1)*(2-1)

1-pchisq(ts,df)

##################

#status1 <- read.csv("~/Desktop/status1.csv")
table(status1)

test=chisq.test(table(status1),correct = F)
test
test$observed
test$expected
(test$observed-test$expected)^2/test$expected
ts=sum((test$observed-test$expected)^2/test$expected)
df=(3-1)*(3-1)

1-pchisq(ts,df)

