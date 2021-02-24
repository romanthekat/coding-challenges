class Common {
    companion object {
        fun assertEquals(got: Any, want: Any) {
            print("%s|got: %s, want: %s\n".format(got == want, got, want))
        }
    }
}