package oit.is.room2.practice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.room2.practice.service.AsyncCountFruit56;

/**
 * /sample5へのリクエストを扱うクラス authenticateの設定をしていれば， /sample5へのアクセスはすべて認証が必要になる
 */
@Controller
@RequestMapping("/sample56")
public class Sample56Controller {

  // コンソールに出力したいログ情報を簡単に使えるようにするためのクラス
  // どこのクラスでもgetLogger内のクラス名を替えるだけで使える
  // 似たようなロガークラスが大量にあるので import org.slf4j.Logger; を間違えないようにすること
  private final Logger logger = LoggerFactory.getLogger(Sample56Controller.class);

  @Autowired
  private AsyncCountFruit56 ac56;

  /**
   * 数字をカウントアップしながらpushしつづけるメソッド
   *
   * @return
   */
  @GetMapping("step1")
  public SseEmitter pushCount() {
    // infoレベルでログを出力する
    logger.info("pushCount");

    // push処理の秘密兵器．これを利用してブラウザにpushする
    // finalは初期化したあとに再代入が行われない変数につける（意図しない再代入を防ぐ）
    final SseEmitter sseEmitter = new SseEmitter();
    this.ac56.count(sseEmitter);
    return sseEmitter;
  }

  @GetMapping("step2")
  public SseEmitter pushFruit() {
    final SseEmitter sseEmitter = new SseEmitter();
    this.ac56.pushFruit(sseEmitter);
    return sseEmitter;

  }

}
