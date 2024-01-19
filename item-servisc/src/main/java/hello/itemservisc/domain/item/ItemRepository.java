package hello.itemservisc.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    //(주의) 싱글톤으로 고려하여 작성
    private static final Map<Long,Item> store = new HashMap<>();
    private static long sequence = 0L;

    // item 저장
    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }
    public Item findById(Long id){
        return store.get(id);
    }
    public List<Item> finall(){
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateparam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateparam.getItemName());
        findItem.setPrice(updateparam.getPrice());
        findItem.setQuantity(updateparam.getQuantity());
    }
    public void clearStore(){
        store.clear();
    }
}
