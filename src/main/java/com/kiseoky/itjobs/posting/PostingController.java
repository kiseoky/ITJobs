package com.kiseoky.itjobs.posting;

import com.kiseoky.itjobs.posting.dto.PostingCreateDTO;
import com.kiseoky.itjobs.posting.dto.PostingUpdateDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/postings")
@RequiredArgsConstructor
@Slf4j
public class PostingController {
    private final PostingService postingService;


    @GetMapping
    public String postings(Model model) {
        model.addAttribute("postings", postingService.getPostings());
        return "posting/postings";
    }

    @GetMapping("/new")
    public String createForm() {
        return "posting/createForm";
    }

    @PostMapping("/new")
    public String create(PostingCreateDTO postingCreateDTO) {
        Posting post = postingService.post(postingCreateDTO);

        return "redirect:/postings/" + post.getId();
    }


    @PostMapping
    public String post(@RequestBody PostingCreateDTO posting) {
        Posting post = postingService.post(posting);
        return "redirect:/posting/" + post.getId();
    }

    @GetMapping("/{id}")
    public String posting(@PathVariable Long id, Model model) {
        model.addAttribute("posting", postingService.getPosting(id).get());
        return "posting/posting";
    }

    @PatchMapping("/{id}")
    public String updatePosting(@PathVariable Long id, @RequestBody PostingUpdateDTO postingUpdateDTO) {
        postingService.update(id, postingUpdateDTO);
        return "redirect:/posting/" + id;
    }
}
