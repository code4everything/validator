## SpringMvc 参数校验注解扩展包

定义了一些`SpringMVC`通用的参数校验注解，轻松实现入参的校验，提高接口的健壮性，避免生成一些不必要的脏数据

### 使用

``` xml
<repository>
    <id>ease-maven</id>
    <url>https://code4everything.gitee.io/repository/maven</url>
</repository>
```

``` xml
<dependency>
    <groupId>org.code4everything</groupId>
    <artifactId>validator</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 校验Body

``` java
@Data
public class BodyVO {

    @Chinese(has = true)
    private String chinese;

    @EndWith("suffix")
    private String suffix;
}
```

``` java
@RestController
public class TestController {

    @GetMapping("/validation/body")
    public String validateBody(@Valid @RequestBody BodyVO bodyVO) {
        return "success";
    }
}
```

### 校验参数

``` java
@Validated
@RestController
public class TestController {

    @GetMapping("/validation/body")
    public String validateQueryString(@Letter(lowerCase = true) String letter, @Mobile String phoneNumber) {
        return "success";
    }
}
```

