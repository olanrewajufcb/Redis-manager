//package com.sf.br.redismanager;
//
//import org.junit.AfterClass;
//import org.junit.internal.runners.statements.Fail;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.Spy;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.redis.cache.RedisCache;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.data.redis.serializer.GenericToStringSerializer;
//
//import java.security.KeyFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class CachedManagerImplTest {
//
//    @Mock
//    private RedisTemplate<String, Object> redisTemplate;
//
//    private CachedManagerImpl cachedManagerImplUnderTest;
//
//    @Mock
//    private ValueOperations<String, Object> valueOperations;
//
//    @Spy
//    RedisCache cache;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//        Mockito.when(redisTemplate.opsForValue()).thenReturn(valueOperations);
//        cachedManagerImplUnderTest = new CachedManagerImpl(redisTemplate);
//
//    }
//
//
//
//
//    @Test
//    void testGetValueShouldReturnNullWhenCacheHasNoValue() {
//        String key = "token";
//        final Object result = cachedManagerImplUnderTest.getValue(key);
//
//      assertTrue(result == null);
//    }
//
//    @Test
//    public void testPutValue() {
//
//        redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
//        cachedManagerImplUnderTest.putValue("key", "value");
//    }
//
//
//
//    @Test
//    void testPutValueShouldReturnTrueWhenDataIsCachedSuccessfully() {
//        // Setup
//        redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Object.class));
//        final boolean result = cachedManagerImplUnderTest.putValue("key", "item", 0);
//        // Verify the results
//        assertTrue(result);
//    }
//
//    @Test
//    void testRemoveItem() {
//        // Setup
////        redisTemplate.setHashKeySerializer(new GenericToStringSerializer<>(Object.class));
////        // Run the test
////        String key = "key";
////        Object val = "some value";
////
////        boolean deleted = redisTemplate.delete(key);
////       when(cachedManagerImplUnderTest.removeItem("key")).thenReturn(deleted);
////        verify(cachedManagerImplUnderTest).removeItem(key);
//    }
//
//
//}
