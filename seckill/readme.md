# 配置thymeleaf的心酸
- 加入依赖：thymeleaf+spring
- xml

注意：class="org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver">

## thymeleaf显示
- 时间格式化
- url拼接(+)

## thymeleaf之js中引用变量值
- <script th:inline="javascript" ></script>
- [[${obj.property}]]
