package hello.itemservisc.domain.item.basic;

import hello.itemservisc.domain.item.Item;
import hello.itemservisc.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {
    private final ItemRepository itemRepository;

    @GetMapping()
    public String items(Model model){
        List<Item> items = itemRepository.finAll();
        model.addAttribute("items",items);

        return "basic/items";
    }



    @PostConstruct
    public void init(){
        itemRepository.save(new Item("test",20000,20));
        itemRepository.save(new Item("tes2",10000,230));
    }
}
