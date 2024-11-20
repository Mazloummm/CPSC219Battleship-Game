# Unit 1: One Sample Hypothesis Testing
T_Calc = (x_bar - mu) / (s / sqrt(n)) # Sigma Unknown
Z_Calc = (x_bar - mu) / (sigma / sqrt(n)) # Sigma Known
# Critical Value finds the Z/T value for a given alpha
CV = qt(alpha,df) or 1-qt(alpha,df) # Left Tail and Right Tail
CV = qt(alpha/2,df) # Two Tail
# P Value finds the probability of the Z/T value
P_value = pt(T_Calc,df) or 1-pt(T_Calc,df) # Left Tail and Right Tail
P_value = 2*pt(T_Calc,df) or 2*(1-pt(T_Calc,df)) # Two Tail

# Hypothesis test for Proportion (p)
Z_Calc = (p_hat - p) / sqrt((p*(1-p))/n)
CV = qnorm(alpha) or qnorm(1-alpha) # Left Tail and Right Tail
CV = qnorm(alpha/2) or qnorm(1-(alpha/2)) # Two Tail
P_value = pnorm(Z_Calc) or 1-pnorm(Z_Calc) # Left Tail and Right Tail
P_value = 2*pnorm(Z_Calc) or 2*(1-pnorm(Z_Calc)) # Two Tail

# Power of a hypothesis test
Type_I_Error = alpha # P(Reject H0 | H0 is True)
Type_II_Error = beta # P(Fail to Reject H0 | H0 is False)
Not_Beta = 1 - beta # Power of the test
Not_Alpha = 1 - alpha # Confidence Level

CV = qnorm(alpha, mu_not, sigma/sqrt(n)) or qnorm(1-alpha, mu_not, sigma/sqrt(n)) # Left Tail and Right Tail
CV = qnorm(alpha/2, mu_not, sigma/sqrt(n)) or qnorm(1-(alpha/2), mu_not, sigma/sqrt(n)) # Two Tail
1-beta = 1-pnorm(CV, mu, sigma/sqrt(n)) # Power of the test for a Right Tail

CV = qnorm(1-alpha, mu_not, sigma/sqrt(n)) # Critical Value
so that 1-beta = 1-pnorm(qnorm(1-alpha, mu_not, sigma/sqrt(n)), mu, sigma/sqrt(n)) # Power of the test

1-beta = 1-pnorm(qnorm(alpha, mu, sigma/sqrt(n)), mu_not, sigma/sqrt(n)) # Power of the test for a Left Tail
1-beta = 2*pnorm(qnorm(alpha, mu, sigma/sqrt(n)), mu_not, sigma/sqrt(n)) # Power of the test for a Two Tail

# Unit 2: Two Sample Hypothesis Testing
P_value = # Where H0 is true, the probability of observing more evidence against H0 is the p-value
tsum.test(mean.x = x_bar1, mean.y = x_bar2, sd.x = s1, sd.y = s2, n.x = n1, n.y = n2, alternative = "two.sided", mu = 0, var.equal = FALSE) # Two Sample T Test
t.test(x, y, alternative = "two.sided", mu = 0, paired = FALSE, var.equal = FALSE) # Two Sample T Test
# Rest of the code is in pictures

# Unit 3: Chi-Square Distribution
# 1. Test of population variance or population standard deviation
    # Ho: Sigma = ? or Ho: Sigma^2 = ? (Variance)
    # Ha: Sigma != ? or Ha: Sigma^2 != ? (Variance)
# 2. Test of independence between two categorical variables
    # Ho: The two variables are independent
    # Ha: The two variables are dependent
# 3. Test of goodness of fit
    # Ho: The observed data fits the expected distribution
    # Ha: The observed data does not fit the expected distribution

# Chi-Square Distribution
CV = qchisq(1-alpha, df) # Right Tail
CV = qchisq(alpha, df) # Left Tail
CV = qchisq(1-(alpha/2) or alpha/2, df) # Two Tail
1-alpha = pchisq(CV, df)
Test_Statistic = (n-1)*s^2/sigma^2
P_value = 1-pchisq(Test_Statistic, df) or pchisq(Test_Statistic, df) # Right and Left Tail
library(EnvStats)
varTest(x, sigma.squared = sigma^2, alternative = ) # Test of population variance

# Test of independence between two categorical variables
Test_Statistic = sum((O-E)^2/E)
df = (r-1)(c-1) # r = number of rows, c = number of columns
table(data)
chisq.test(table(data), correct = FALSE) # Test of independence

# Chi-Square Test of Homogeneity
df=matrix(c(50,30,20,50,80,70),ncol = 3,byrow = T)
colnames(df)=c("The Lone Ranger","Sesame Street","The Simpsons")
rownames(df)=c("Boys","Girls")
df
chisq.test(df,correct=F)
test=chisq.test(df,correct=F)
test$observed
test$expected
(test$observed-test$expected)^2/test$expected
sum((test$observed-test$expected)^2/test$expected)

# Chi-Square Test of Goodness of Fit
chisq.test(table(data), p = c(0.2, 0.3, 0.5)) # Test of goodness of fit

# Unit 4: Linear Regression
plot(x, y) # Scatterplot
cor(x, y) # Correlation Coefficient (r)
(cor(x, y))^2 # Coefficient of Determination (r^2)
fit=lm(y~x) # Linear Regression
summary(fit) # Summary of the Linear Regression
anova(fit) # ANOVA Table
confint(fit, level = 0.95) # Confidence Interval
ciy=predict(fit,data.frame(x = ?),se.fit=T,interval="confidence",level=.95) # Confidence Interval at x = ?, known mean
piy=predict(fit,data.frame(x = ?),se.fit=T,interval="prediction") # Prediction Interval at x = ?, unknown mean

# Unit 5: ANOVA
# One Way ANOVA
ad.test(x) # Test for Normality
st1=stack(data)
st2=na.omit(st1)
leveneTest(values~ind, data = ) # Test for equal variance
df = n - k # n - number of observations, k - number of columns
my.anova=aov(values~ind,data = st2) # One Way ANOVA
summary(my.anova)
# Tukey's HSD Test
ci = TukeyHSD(my.anova, conf.level = 0.95) # Tukey's HSD Test
(ci$ind[,3]-ci$ind[,2])/2 # Margin of Error
# Kruskal-Wallis Test if the data is not normally distributed or the variances are not equal
kruskal.test(values~ind, data = ) # Test for equal medians
# Two Way ANOVA
my.anova=aov(values~ind1+ind2,data = ) # Two Way ANOVA
# Repeated Measures ANOVA
my.anova=aov(values~ind1*ind2,data = ) # Repeated Measures ANOVA
# No Interaction = lines are parallel
# Interaction = lines are intersecting
# Slight Interaction = lines may intersect but are mostly parallel

# Unit 6: Multiple Regression
fit=lm(y~x1+x2+x3) or lm(y~., data = ) # Multiple Regression
summary(fit) # Summary of the Multiple Regression
anova(fit) # ANOVA Table
confint(fit, level = 0.95) # Confidence Interval
ciy=predict(fit,data.frame(x1 = ?, x2 = ?, x3 = ?),se.fit=T,interval="confidence",level=.95) # Confidence Interval at x1 = ?, x2 = ?, x3 = ?, known mean
piy=predict(fit,data.frame(x1 = ?, x2 = ?, x3 = ?),se.fit=T,interval="prediction") # Prediction Interval at x1 = ?, x2 = ?, x3 = ?, unknown mean

# Muli-Collinearity
library(MASS)
step.model=stepAIC(fit, direction = "both", trace = FALSE) # Stepwise Regression
# Rid of variables that don't contribute to the model
# Beware of Extrapolation
# You can use catagorical variables in regression by converting them to dummy variables





  
