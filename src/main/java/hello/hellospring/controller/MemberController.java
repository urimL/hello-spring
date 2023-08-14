package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class MemberController {
    //새로운 instance를 생성하는 것보다 생성자를 이용하여
    // spring container에서 받아서 쓰도록 작성해야된다.
    private final MemberService memberService;

    @Autowired //
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
