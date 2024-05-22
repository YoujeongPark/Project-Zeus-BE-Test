package com.konada.Konada.controller;

import com.konada.Konada.entity.Post;
import com.konada.Konada.entity.Vote;
import com.konada.Konada.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @GetMapping("/votes_read")
    public List<Vote> getAllVotes() {
        return voteService.getAllVotes();
    }

//    @GetMapping("/{id}")
//    public Vote getVoteById(@PathVariable Long id) {
//        return voteService.getVoteById(id);
//    }

    @GetMapping("/vote_read")
    public Post getVoteById(@RequestParam("post_id") Long postId) {
        return voteService.getVoteById(postId).getPost();
    }

    @PostMapping("/vote_post")
    public Vote createVote(@RequestBody Vote vote) {
        return voteService.saveVote(vote);
    }

    @DeleteMapping("/vote_delete")
    public void deleteVote(@PathVariable Long id) {
        voteService.deleteVote(id);
    }

}

