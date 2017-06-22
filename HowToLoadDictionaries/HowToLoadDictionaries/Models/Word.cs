using System.Collections.Generic;
using System.Linq;

namespace HowToLoadDictionaries.Models
{
    public class Word
    {
        public string EnglishWord { set; get; }
        public HashSet<string> Meanings { set; get; }

        public Word()
        {
            Meanings = new HashSet<string>();
        }

        public override string ToString()
        {
            var aggregate = Meanings.Any() ? Meanings.Aggregate((s1, s2) => $"{s1}, {s2}") : "";
            return $"{EnglishWord} : {aggregate}";
        }

        public override bool Equals(object obj)
        {
            var word = obj as Word;
            if (word == null)
                return false;

            return this.EnglishWord == word.EnglishWord &&
                   this.ToString() == word.ToString();

        }

        public override int GetHashCode()
        {
            unchecked
            {
                var hash = 17;
                hash = hash * 23 + EnglishWord.GetHashCode();
                hash = hash * 23 + this.ToString().GetHashCode();
                return hash;
            }
        }
    }
}