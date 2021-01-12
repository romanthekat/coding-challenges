def assert_equal(got, want) -> bool:
    equal = got == want
    print(f"{equal}|got: {got}, want: {want}")
    return equal
