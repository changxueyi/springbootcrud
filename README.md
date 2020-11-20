4.3 StringRedisTemplate 与 RedisTemplate
RedisTemplate 对五种数据结构分别定义了操作

redisTemplate.opsForValue();

操作字符串

redisTemplate.opsForHash();

操作hash

redisTemplate.opsForList();

操作list

redisTemplate.opsForSet();

操作set

redisTemplate.opsForZSet();

操作有序set

如果操作字符串的话，建议用 StringRedisTemplate 。

文章中使用的ES
https://www.jianshu.com/p/bd2da1cde6f5?utm_campaign=maleskine&utm_content=note&utm_medium=reader_share&utm_source=weixin

