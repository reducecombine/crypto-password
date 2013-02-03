(ns crypto.password.test.pbkdf2
  (:use clojure.test)
  (:require [crypto.password.pbkdf2 :as password]))

(deftest test-passwords
  (are [s] (password/check s (password/encrypt s))
    "a"
    "foo"
    "password"
    "Testing"
    "Test123"
    "ÁäñßOÔ"
    "großpösna"
    "Some rather long pass phrase perhaps out of a book or poem")
  
  (are [s r] (not (password/check r (password/encrypt s)))
    "a" "b"
    "a" "a "
    "aaaaa" "aaaaa\n"
    "großpösna" "grossposna"))
