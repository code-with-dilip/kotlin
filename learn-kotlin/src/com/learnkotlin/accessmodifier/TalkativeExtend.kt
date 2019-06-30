package com.learnkotlin.accessmodifier

internal class TalkativeExtend : Talkative() {
    override  fun whisper() {
        println("WHISPER in TalkativeExtend")
        super.whisper();
    }
    protected fun callWhisperInTalkative() = {
        val talkative = Talkative()
    }


}


fun main(args: Array<String>) {
    val talkative = Talkative();
    println(talkative.speak())

    val talkativeExtend = TalkativeExtend();
    //talkativeExtend.whisper();
}